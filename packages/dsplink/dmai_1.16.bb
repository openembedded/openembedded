DESCRIPTION = "Davinci (and OMAP) Multimedia Application Interface"
DEPENDS = "virtual/kernel codec-engine"
LICENCE = "unknown"

require ti-paths.inc

# https://www-a.ti.com/downloads/sds_support/applications_packages/dmai/dmai_1_16_00_03/dmai_setuplinux_1_16_00_03.bin
# Install the above link and put the dmai_1_16_00_03.tar.gz file in the same directory as this recipe
SRC_URI = "file://dmai_1_16_00_03.tar.gz \
          "

S = "${WORKDIR}/dmai_1_16_00_03"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_compile () {
	:
}

do_install () {
	:
}

do_stage () {
	:
}

