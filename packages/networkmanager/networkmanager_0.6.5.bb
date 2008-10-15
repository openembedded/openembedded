require networkmanager.inc

FILE_PR = "r2"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/NetworkManager/0.6/NetworkManager-${PV}.tar.bz2 \
	  file://NetworkManager \
	  file://99_networkmanager"

S = "${WORKDIR}/NetworkManager-${PV}/"

