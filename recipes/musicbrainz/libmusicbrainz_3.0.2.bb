require ${PN}.inc

PR = "r2"

SRC_URI_append = " file://libmusicbrainz-3.0.2-gcc-4.4-fix.patch \
	file://libmusicbrainz-3.0.2-cmake-neon.patch"


SRC_URI[md5sum] = "648ecd43f7b80852419aaf73702bc23f"
SRC_URI[sha256sum] = "b9a35e56826239add731cf083108cbc313d4a2d1770e6f5006966daa66a21eda"
