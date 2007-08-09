require bluez-utils.inc

PACKAGES =+ "${PN}-ciptool"

SRC_URI += "file://uclibc-fix.patch;patch=1 \
            file://ppoll-uclibc-arm-r0.patch;patch=1 "

FILES_${PN}-ciptool = "/bin/ciptool"
RREPLACES_${PN}-ciptool = "bluez-utils-dbus-ciptool"
RCONFLICTS_${PN}-ciptool = "bluez-utils-dbus-ciptool bluez-utils-nodbus"


PR = "r5"
