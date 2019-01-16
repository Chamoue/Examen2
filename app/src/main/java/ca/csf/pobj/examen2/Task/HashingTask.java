package ca.csf.pobj.examen2.Task;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import ca.csf.pobj.examen2.Model.HashListener;
import ca.csf.pobj.examen2.Model.Hasher;

public class HashingTask extends AsyncTask<String, Void, String> {

    private List<HashListener> listeners = new ArrayList<>();

    @Override
    protected String doInBackground(String... strings) {
        Hasher hasher = new Hasher();
        return hasher.completeHashing(strings[0]);
    }

    public void addToListeners(HashListener listener) {
        this.listeners.add(listener);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        for (HashListener hashListener : this.listeners) {
            hashListener.onHashingTaskCompleted(s);
        }
    }
}
