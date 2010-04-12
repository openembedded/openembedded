require hostap-daemon.inc

SRC_URI_append_nylon = "\
	file://hostap-no-bsd.patch;patch=1"


PR = "r2"

SRC_URI[md5sum] = "79810ff32f6f12a37dc7827ce18af533"
SRC_URI[sha256sum] = "684636fd31ad2cbe989a19f2ce844b7d1c46c1e009cda37c92f5d9ead9ba18b8"
