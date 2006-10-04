SECTION = "libs"

inherit native

require ${@bb.data.getVar('P', d , 1).replace('-native-', '_')}.bb
