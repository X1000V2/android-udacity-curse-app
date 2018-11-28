package l.b.v.udacitytestapp.mainMenu

class MenuPresenter: MenuContract.Presenter {

    private var mView: MenuContract.View? = null

    override fun setView(view: MenuContract.View) {
        this.mView = view
    }

}