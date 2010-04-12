require contacts.inc

PR = "r1"

SRC_URI = "http://pimlico-project.org/sources/${PN}/${PN}-${PV}.tar.gz \
	   file://stock_contact.png \
	   file://stock_person.png  \
	   file://contacts-owl-window-menu.patch;patch=1 \
	   file://contacts-util-fixup.diff;patch=1 \
	  "

SRC_URI[md5sum] = "dbcff54980ec6d6203c290dc409b5598"
SRC_URI[sha256sum] = "7ab8f1fa23a432029242c046755875ac6558ea6e9c0871dd6c527b85adfafad8"
