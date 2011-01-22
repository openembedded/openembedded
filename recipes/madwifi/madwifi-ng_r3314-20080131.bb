# Bitbake recipe for the madwifi-ng driver

require madwifi-ng_r.inc

# PR set after the include, to override what's set in the included file.
PR = "${INC_PR}.2"

# versions of OpenWrt backfire (10.03)
HAL_VERSION = "20090508"
SRCREV = "20550"

SRC_URI += " \
        svn://svn.openwrt.org/openwrt/trunk/package/madwifi;module=patches \
        http://mirror2.openwrt.org/sources/ath_hal-${HAL_VERSION}.tgz;name=hal \
        file://fix-target-mips32.patch \
        file://remove-wprobe.patch;apply=no \
        "
SRC_URI[md5sum] = "2c7352cbbdac995de8c3bce5b80db5f2"
SRC_URI[sha256sum] = "0599c75b95ba63bdc554cb8124192e62c75fbeb71b9e8a5a7bc351c8e0666758"
SRC_URI[hal.md5sum] = "4ab7ae8bdb96c0be388c98bf8f92d5ca"
SRC_URI[hal.sha256sum] = "ced93d25aea7ee43807147a0269e69a072e718d59e7dab904bbe48b900409483"

addtask postpatch after do_patch before do_configure

do_postpatch() {
        rm -rf hal
        cp -a ${WORKDIR}/ath_hal-${HAL_VERSION} hal
        rm -f ${WORKDIR}/patches/104-autocreate_none.patch
        rm -f ${WORKDIR}/patches/446-single_module.patch
        for i in ${WORKDIR}/patches/*.patch; do
                oenote "Applying openwrt patch '$i'"
                patch -p1 -i $i
        done
        patch -p1 -i ${WORKDIR}/remove-wprobe.patch
}
