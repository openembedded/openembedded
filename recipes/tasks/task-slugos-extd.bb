DESCRIPTION = "Task packages for the SlugOS Extended image"
PR = "r2"
LICENSE = "MIT"

inherit task

RNG_TOOLS_PACKAGE = "rng-tools"
RNG_TOOLS_PACKAGE_libc-uclibc = ""

RDEPENDS_${PN} = "\
  ${RNG_TOOLS_PACKAGE} \
  kexec \
"

RRECOMMENDS_${PN} = "\
  kernel-module-libata \
  kernel-module-pata-artop \
  kernel-module-via-velocity \
  kernel-module-netconsole \
"

# Other candidate packages that have been considered and
# may be included in the future:
#
# portmap \
# kernel-module-isofs \
# kernel-module-udf \
# kernel-module-loop \
# wireless-tools \
# wpa-supplicant \
# zd1211-firmware kernel-module-zd1211rw \
# madwifi-ng-modules madwifi-ng-tools \
