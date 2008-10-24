DESCRIPTION = "Task Mamona: Necessary packages for running a systemtap enabled system"
PR = "r1"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS = "\
    libcap \
    systemtap \
    task-mamona-sdk \
"
