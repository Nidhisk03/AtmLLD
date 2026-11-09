package dispenser;

public class NoteDispensor implements DispenserHandler{

    DispenserHandler nextChain;
    int noteValue;
    int noteNumber;

    public NoteDispensor(int noteValue, int noteNumber) {
        this.noteValue = noteValue;
        this.noteNumber = noteNumber;
    }



    @Override
    public void setNext(DispenserHandler handler) {
       this.nextChain = handler;
    }

    @Override
    public void dispense(int amount) {
           if(amount>=noteValue){
               int num = Math.min(amount/noteValue, noteNumber);
               int remainingAmount = amount-(num* noteValue);

               if (num > 0) {
                   System.out.println("Dispensing " + num + " x $" + noteValue + " note(s)");
                   this.noteNumber -= num;
               }

               if(remainingAmount!=0 && this.nextChain!=null){
                   this.nextChain.dispense(remainingAmount);
               }

           }else if(this.nextChain!=null){
               this.nextChain.dispense(amount);
           }


    }

    @Override
    public boolean canDispense(int amount) {
        if(amount<0)return false;
        if(amount==0)return true;
        int numToUse = Math.min(amount / noteValue, this.noteNumber);
        int remainingAmount = amount - (numToUse * noteValue);


        if (remainingAmount == 0) return true;
        if (this.nextChain != null) {
            return this.nextChain.canDispense(remainingAmount);
        }
        return false;

    }
}
