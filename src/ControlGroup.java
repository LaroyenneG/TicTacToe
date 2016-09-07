/**
 * Created by guillaume on 07/09/16.
 */
public class ControlGroup {

    private Model model;
    private Windows vue;
    public ControlButton controlButton;
    public ControlMenu controlMenu;


    public ControlGroup(Model model) {

        this.model = model;

        vue = new Windows(model);

        controlButton = new ControlButton(model,vue);
        controlMenu = new ControlMenu(model,vue);


    }
}
