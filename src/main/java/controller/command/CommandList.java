package controller.command;

import controller.command.commandImpl.*;

/**
 * Enum that contains enumeration of all commands
 */
public enum CommandList {
    LOCALIZATION(new LocalizationCommand()),
    AUTHORIZATION(new AuthorizationCommand()),
    REGISTRATION(new RegistrationCommand()),
    LOG_OUT(new LogOutCommand()),
    CREATE_MASTER(new MasterCreationCommand()),
    UPDATE_MASTER(new UpdateMasterCommand()),
    MASTER_LIST(new MasterListCommand()),
    REDIRECT_TO_RECORD_COMMAND(new RedirectToRecordCommand()),
    GET_RECORDS_FOR_DATE(new GetRecordsForDateCommand()),
    CREATE_RECORD(new CreateRecordCommand()),
    USER_PAGE_INFO(new UserPageInfoCommand()),
    ADD_COMMENT(new AddCommentCommand()),
    GET_ALL_COMMENTS(new GetAllCommentsCommand()),
    GET_PRICE_LIST(new GetPriceListCommand()),
    ADD_SERVICE_PRICE(new AddServicePriceCommand());

    private Command command;


    CommandList(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
