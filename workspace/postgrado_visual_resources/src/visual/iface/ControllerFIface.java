package visual.iface;

public interface ControllerFIface {
	void settingComponents ();
	
	void loadData ();

	void initialize ();

	void executeData ();

	boolean checkData ();

	void recopileData ();

	void undoData ();

	void addListeners ();

	public boolean isInsertOk();

	public boolean isUpdateOk();
}