
SRC_URI = "file://zzapsplash-init"

do_install_prepend() {
	install -d "${D}${sysconfdir}/init.d/"
	install -m 0755 "${WORKDIR}/zzapsplash-init" "${D}${sysconfdir}/init.d/zzapsplash"
}

inherit update-rc.d

INITSCRIPT_NAME = "zzapsplash"
INITSCRIPT_PARAMS = "start 99 5 S ."

