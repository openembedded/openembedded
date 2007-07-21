DESCRIPTION = "DBus and HAL convenience wrappers for EFL"
DEPENDS = "dbus ecore"
LICENSE = "MIT"
PR = "r0"

inherit efl_library

SRC_URI = "${E_CVS};module=e17/proto/e_dbus"
S = "${WORKDIR}/e_dbus"

# TODO increase package granularity

