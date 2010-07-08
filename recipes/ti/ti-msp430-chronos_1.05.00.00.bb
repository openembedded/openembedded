DESCRIPTION = "eZ430 Chronos Tools - MSP430 Development Kit/Watch"
HOMEPAGE = "http://processors.wiki.ti.com/index.php/EZ430-Chronos"
LICENCE = "unknown"
SECTION = "multimedia"

PV = "1_05_00_00"
PR = "2"

SRC_URI = "http://focus.ti.com/lit/sw/slac388/slac388.zip;name=slac388zip"

SRC_URI[slac388zip.md5sum] = "22d4104a07af584222828fb377793796"
SRC_URI[slac388zip.sha256sum] = "1c9cd1e36015e8db3b36c98be41907628144b76002b3f76b27fd310f4bd35ad7"

require ti-paths.inc
require ti-staging.inc
require ti-eula-unpack.inc

S = "${WORKDIR}/ti/eZ430-Chronos"

BINFILE="Chronos-Setup"
TI_BIN_UNPK_CMDS="Y:workdir:"

do_unpack_append() {
    os.system('mv "Texas Instruments" ti')
}

do_compile() {
    echo "Do Nothing for Now"
}

do_install() {

    install -d ${D}/${installdir}/ti-msp430-chronos-apps
    cp -pPrf "${S}"/"Control Center"/* ${D}/${installdir}/ti-msp430-chronos-apps

    # Remove dos formatting
    dos2unix "${D}/${installdir}/ti-msp430-chronos-apps/Chronos Data Logger"/*
    dos2unix "${D}/${installdir}/ti-msp430-chronos-apps/Chronos Control Center"/*

    # Should probably also remove hardcoded script reference to tcl8.5
}

PACKAGES += "ti-msp430-chronos-apps"
FILES_ti-msp430-chronos-apps = "${installdir}/ti-msp430-chronos-apps/*"

RDEPENDS_ti-msp430-chronos-apps += " tcl tk xdotool"
