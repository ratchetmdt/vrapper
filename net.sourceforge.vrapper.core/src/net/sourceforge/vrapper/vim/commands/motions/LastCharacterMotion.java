package net.sourceforge.vrapper.vim.commands.motions;

import net.sourceforge.vrapper.platform.TextContent;
import net.sourceforge.vrapper.utils.LineInformation;
import net.sourceforge.vrapper.utils.VimUtils;
import net.sourceforge.vrapper.vim.commands.BorderPolicy;
import net.sourceforge.vrapper.vim.commands.CommandExecutionException;

public class LastCharacterMotion extends AbstractModelSideMotion {

    public static final Motion INSTANCE = new LastCharacterMotion();

    @Override
    public BorderPolicy borderPolicy() {
        return BorderPolicy.INCLUSIVE;
    }

    @Override
    protected int destination(int offset, TextContent content, int count)
            throws CommandExecutionException {
        LineInformation lineInfo = content.getLineInformationOfOffset(offset);
        return VimUtils.getLastNonWhiteSpaceOffset(content, lineInfo);
    }
}
