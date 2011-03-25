require x-load.inc

DEFAULT_PREFERENCE_omap3-pandora = "-1"

FILESPATHPKG_prepend = "x-load-git:x-load-git/${MACHINE}"

PV = "1.5.0+${PR}+gitr${SRCREV}"
PR ="r22"
PE = "1"

SRCREV = "b6bbfe7848de547b64edf1c363c86cec4921b517"
SRC_URI = "git://gitorious.org/x-loader/x-loader.git;branch=master;protocol=git \
          "

XLOAD_MACHINE_beagleboard = "omap3530beagle_config"

SRCREV_omap3-touchbook = "319b26586fafb86f919f514bcd175838aaab96b3"
SRC_URI_omap3-touchbook = "   git://gitorious.org/x-load-omap3/mainline.git;branch=master;protocol=git \
                              file://name.patch \
                              file://screen-off.patch \
                             "

# TI PSP v1.46_OMAPPSP_03.00.01.06 (Tag is one commit different)
SRC_URI_am3517-crane = "git://arago-project.org/git/projects/x-load-omap3.git;protocol=git \
                        file://0001-Added-support-for-AM3517-CraneBoard.patch \
"
SRCREV_am3517-crane = "fc6d5be15c703d21aef0ae0b8c02177721f0445f"
PV_am3517-crane = "1.46+${PR}+gitr${SRCREV}"

# TI PSP v1.46_OMAPPSP_03.00.01.06 (Tag is one commit different)
SRC_URI_omap3evm = "git://arago-project.org/git/projects/x-load-omap3.git;protocol=git"
SRCREV_omap3evm = "fc6d5be15c703d21aef0ae0b8c02177721f0445f"
PV_omap3evm = "1.46+${PR}+gitr${SRCREV}"

# TI PSP v1.46_OMAPPSP_03.00.01.06 (Tag is one commit different)
SRC_URI_dm37x-evm = "git://arago-project.org/git/projects/x-load-omap3.git;protocol=git"
SRCREV_dm37x-evm = "fc6d5be15c703d21aef0ae0b8c02177721f0445f"
PV_dm37x-evm = "1.46+${PR}+gitr${SRCREV}"

# TI PSP v1.46_OMAPPSP_03.00.01.06 (Tag is one commit different)
SRC_URI_am37x-evm = "git://arago-project.org/git/projects/x-load-omap3.git;protocol=git"
SRCREV_am37x-evm = "fc6d5be15c703d21aef0ae0b8c02177721f0445f"
PV_am37x-evm = "1.46+${PR}+gitr${SRCREV}"

# TI PSP v1.46_OMAPPSP_03.00.01.06 (Tag is one commit different)
SRC_URI_am3517-evm = "git://arago-project.org/git/projects/x-load-omap3.git;protocol=git"
SRCREV_am3517-evm = "fc6d5be15c703d21aef0ae0b8c02177721f0445f"
PV_am3517-evm = "1.46+${PR}+gitr${SRCREV}"

SRC_URI_omapzoom2 = "git://dev.omapzoom.org/pub/scm/bootloader/x-loader.git;protocol=git \
                     http://www.xora.org.uk/~dp/oe/zoom2.u-boot.git_78e778e0ea884306841c6499851a1e35177d81d0.tar.gz;name=uboot"
SRCREV_omapzoom2 = "599c6cb87ee0c01fd6632b24f6d7e0a2b3ea5d0a"

SRC_URI_omapzoom36x = "git://dev.omapzoom.org/pub/scm/bootloader/x-loader.git;protocol=git \
                       http://www.xora.org.uk/~dp/oe/zoom2.u-boot.git_78e778e0ea884306841c6499851a1e35177d81d0.tar.gz;name=uboot"
SRCREV_omapzoom36x = "251d92815500143aefdbe3b3558a0ce6daeaebdc"

SRC_URI[uboot.md5sum] = "e68b30714d22ce2f926d2dd19f94a2be"
SRC_URI[uboot.sha256sum] = "e7e5c87d939cc4c1f14d17ea0814b0bed97021c7afca3ef9053c896c2b5bdd6f"

SRC_URI_igep0020 = "git://git.igep.es/pub/scm/x-loader.git;protocol=git \
                    file://remove-final-ldflags.patch"
SRCREV_igep0020 = "213d95fcadc54424c796259928d7c15c5a2945a0"
PV_igep0020 = "1.43+${PR}+gitr${SRCREV}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
