package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MenuItemsID {
    MENU_ITEMS("#menu-item-"),
    TESTERS_HUB("2822"),
    DEMO_TESTING_SITE("2823"),
    DATE_PICK("2827"),
    ALERT_BOX("2834"),
    DIALOG_BOX("2828");
    private String id;
}
