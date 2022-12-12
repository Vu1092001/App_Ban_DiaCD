package event;

import java.rmi.RemoteException;

public interface EventMenuSelected {

    public void selected(int index) throws RemoteException;
}
