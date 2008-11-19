require u-boot.inc
PR ="r19"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "
SRCREV_davinci-sffsdr = "4b50cd12a3b3c644153c4cf393f4a4c12289e5aa"
SRCREV_davinci-dvevm = "4b50cd12a3b3c644153c4cf393f4a4c12289e5aa"
SRCREV_akita = "9bf86baaa3b35b25baa2d664e2f7f6cafad689ee"
SRCREV_spitz = "9bf86baaa3b35b25baa2d664e2f7f6cafad689ee"
SRCREV_c7x0 = "9bf86baaa3b35b25baa2d664e2f7f6cafad689ee"

SRC_URI_beagleboard = "git://www.sakoman.net/git/u-boot-omap3.git;branch=omap3;protocol=git" 
SRCREV_beagleboard = "1e329ec630b31803ee191d2ee335214662b5bfea"
PV_beagleboard = "2008.10+${PR}+gitr${SRCREV}"

SRC_URI_omap3evm = "git://www.sakoman.net/git/u-boot-omap3.git;branch=omap3;protocol=git" 
SRCREV_omap3evm = "1e329ec630b31803ee191d2ee335214662b5bfea"
PV_omap3evm = "2008.10+${PR}+gitr${SRCREV}"

SRC_URI_neuros-osd2 = "git://git.neurostechnology.com/git/u-boot;protocol=git;branch=neuros"
SRCREV_neuros-osd2 = "df6de5f4ff79dc43ba2a79a3afa975d22ec273b5"

SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git"
SRCREV_sequoa = "cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "
SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git;tag=cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093 "

SRC_URI_neuros-osd2 += "file://Makefile-fix.patch;patch=1"
SRC_URI_append_akita = "file://pdaXrom-u-boot.patch;patch=1 \
                        file://uboot-eabi-fix-HACK2.patch;patch=1 \
                        file://akita-standard-partitioning.patch;patch=1 \
                       "
SRC_URI_append_spitz = "file://pdaXrom-u-boot.patch;patch=1 \
                        file://uboot-eabi-fix-HACK2.patch;patch=1 \
                        file://spitz-standard-partitioning.patch;patch=1 \
                       "
SRC_URI_append_c7x0 = "file://pdaXrom-u-boot.patch;patch=1 \
                       file://uboot-eabi-fix-HACK2.patch;patch=1 \
                       file://corgi-standard-partitioning.patch;patch=1 \
                       "

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_configure_prepend_akita() {
        sed -i s:ROOT_FLASH_SIZE:${ROOT_FLASH_SIZE}:g ${S}/include/configs/akita.h
}

do_configure_prepend_spitz() {
        sed -i s:ROOT_FLASH_SIZE:${ROOT_FLASH_SIZE}:g ${S}/include/configs/akita.h
}

do_configure_prepend_c7x0() {
        sed -i s:ROOT_FLASH_SIZE:${ROOT_FLASH_SIZE}:g ${S}/include/configs/corgi.h
}
