DESCRIPTION = "Task Mamona: Necessary packages for running a systemtap enabled system"
PR = "r2"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    libcap \
    task-mamona-sdk \
"
