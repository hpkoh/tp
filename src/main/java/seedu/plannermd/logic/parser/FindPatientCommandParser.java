package seedu.plannermd.logic.parser;

import static seedu.plannermd.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.plannermd.logic.commands.findcommand.FindPatientCommand;
import seedu.plannermd.logic.parser.exceptions.ParseException;
import seedu.plannermd.model.person.NameContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindPatientCommand object
 */
public class FindPatientCommandParser implements Parser<FindPatientCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindPatientCommand
     * and returns a FindPatientCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindPatientCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPatientCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindPatientCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

}
