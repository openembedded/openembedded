require ti-codec-engine.inc

PV = "2_25_00_05"

SRC_URI[cetarball.md5sum] = "618f027c4a471a0658ed999621ac190b"
SRC_URI[cetarball.sha256sum] = "81acdf9236f3062c26356db502837ae13addb35f03c02a847f9b0face9657b51"

do_compile_prepend() {

    # Add OMAPL138 target build configuration
    sed -i  \
        -e 's/# figure out what categories of devices we are to build for/ \
# figure out what categories of devices we are to build for \
ifneq (,$(findstring OMAPL138,$(DEVICES))) \
    DEVICES_DUALCPU := 1 \
endif/g' \
        ${S}/examples/xdcpaths.mak

}

do_install_prepend() {

    # Re-use OMAPL137 system files for OMAPL138
    ln -sf  ${S}/examples/apps/system_files/OMAPL137  ${S}/examples/apps/system_files/OMAPL138 || true
}

do_install_append() {

    # Fix-up loadmodules to use modprobe instead of insmod
    sed -i \
        -e 's/insmod/modprobe/g' \
        -e 's/.ko//g' \
        ${D}/${installdir}/codec-engine-apps/loadmodules.sh
}

