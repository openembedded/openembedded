require m4.inc

PR = "${INC_PR}.0"

SRC_URI += "file://f13-compile.patch;patch=1"

SRC_URI[archive.md5sum] = "e6fb7d08d50d87e796069cff12a52a93"
SRC_URI[archive.sha256sum] = "0885ffa93256353a96b1cf0bcbc4d639ed09953b687e6cc412c4048e656f4dd2"

do_configure() {
	install -m 0644 ${STAGING_DATADIR_NATIVE}/gnu-config/config.sub .
	install -m 0644 ${STAGING_DATADIR_NATIVE}/gnu-config/config.guess .
	oe_runconf
}
