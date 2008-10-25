DESCRIPTION = "Openmoko: Misc. Feed Items for ASU"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r0.08"

inherit task

RDEPENDS_task-openmoko-asu-feed = "\
        xterm \
        openmoko-agpsui \
        task-openmoko-net \
        task-openmoko-ui \
        task-openmoko-base \
        task-openmoko-phone \
        task-openmoko-games \
        task-openmoko-pim \
"
