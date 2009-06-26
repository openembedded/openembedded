DESCRIPTION = "Keyboard map"
SECTION = "base"
RDEPENDS_${PN} = "initscripts console-tools"
LICENSE = "GPL"
PACKAGE_ARCH = "${MACHINE}"
PR = "r21"

inherit update-rc.d

SRC_URI = "file://keymap"

SRC_URI_append_c7x0         = " file://keymap-2.6.map"
SRC_URI_append_tosa         = " file://keymap-2.6.map"
SRC_URI_append_akita        = " file://keymap-2.6.map"
SRC_URI_append_spitz        = " file://keymap-2.6.map"
SRC_URI_append_collie       = " file://keymap-2.6.map"
SRC_URI_append_poodle       = " file://keymap-2.6.map"
SRC_URI_append_h2200        = " file://keymap-2.6.map"
SRC_URI_append_htcuniversal = " file://keymap-2.6.map"
SRC_URI_append_qemux86      = " file://keymap-2.6.map"

SRC_URI_append_jornada6xx   = " file://keymap-620lx-660lx \
				file://keymap-br.map \
				file://keymap-de.map \
				file://keymap-sp.map \
				file://keymap-uk.map \
				"


INITSCRIPT_NAME = "keymap"
INITSCRIPT_PARAMS = "start 01 S ."

do_install () {
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/keymap ${D}${sysconfdir}/init.d/

    case ${MACHINE} in
        c7x0 | tosa | spitz | akita | borzoi | collie | poodle | jornada6xx | h2200 | htcuniversal | qemux86 )
            install -m 0644 ${WORKDIR}/keymap-*.map	${D}${sysconfdir}
            ;;
        *)
            ;;
    esac
}
