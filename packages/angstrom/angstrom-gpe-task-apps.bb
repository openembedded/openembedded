DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r32"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = "\
    gpe-edit \
    gpe-gallery \
    gpe-calculator \
    gpe-clock \
    gpe-plucker \
    gpe-terminal \
    gpe-watch \
    gpe-what \
    matchbox-panel-hacks \
    ${@base_contains("COMBINED_FEATURES", "wifi", "gpe-aerial", "",d)} \
    gpe-soundbite \
    ${@base_contains("MACHINE_FEATURES", "touchscreen", "rosetta", "",d)} \
    gpe-scap \
    gpe-windowlist"

