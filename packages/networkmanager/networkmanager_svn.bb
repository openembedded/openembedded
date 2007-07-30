require networkmanager.inc

PV = "0.6.5+svn${SRCDATE}"
PR = "r0"

SRC_URI="svn://svn.gnome.org/svn/NetworkManager/branches;module=NETWORKMANAGER_0_6_0_RELEASE;proto=http \
	file://NetworkManager \
	file://99_networkmanager"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/NETWORKMANAGER_0_6_0_RELEASE"


