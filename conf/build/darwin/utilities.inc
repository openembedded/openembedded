python darwin_utilities_fixup() {
    import os
    import bb.event

    if isinstance(e, bb.event.ConfigParsed):
        os.environ["COMMAND_MODE"] = "legacy"
}

addhandler darwin_utilities_fixup
