require bluez-utils.inc

PACKAGES =+ "${PN}-ciptool"

FILES_${PN}-ciptool = "/bin/ciptool"
RREPLACES_${PN}-ciptool = "bluez-utils-dbus-ciptool"
RCONFLICTS_${PN}-ciptool = "bluez-utils-dbus-ciptool bluez-utils-nodbus"


PR = "r4"
