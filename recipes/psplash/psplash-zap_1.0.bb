SRC_URI = "file://zzapsplash-init"
PR = "r2"

do_install_prepend() {
	install -d "${D}${sysconfdir}/init.d/"
	install -m 0755 "${WORKDIR}/zzapsplash-init" "${D}${sysconfdir}/init.d/zzapsplash"
}

inherit update-rc.d

RECOMMENDS_${PN} = "psplash-angstrom"
INITSCRIPT_NAME = "zzapsplash"
INITSCRIPT_PARAMS = "start 99 5 S ."

