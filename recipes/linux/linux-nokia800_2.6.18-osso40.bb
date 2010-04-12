require linux-nokia800.inc

PR = "r5"

SRC_URI = "http://repository.maemo.org/pool/maemo3.1/free/source/kernel-source-rx-34_2.6.18.orig.tar.gz;name=kernel \
           http://repository.maemo.org/pool/maemo3.1/free/source/kernel-source-rx-34_2.6.18-osso40.diff.gz;patch=1;name=ossopatch \
           ${RPSRC}/lzo_kernel-r0.patch;patch=1;name=rppatch25 \
           ${RPSRC}/lzo_jffs2-r0.patch;patch=1;name=rppatch26 \
           ${RPSRC}/lzo_crypto-r0b.patch;patch=1;name=rppatch27 \
           ${RPSRC}/lzo_jffs2_lzomode-r0.patch;patch=1;name=rppatch28 \
           ${RPSRC}/lzo_jffs2_sysfs-r0.patch;patch=1;name=rppatch29 \
           file://fix_oprofile.patch;patch=1 \
           file://linux-2.6-limits.patch;patch=1 \
	   file://defconfig"

SRC_URI_append_nokia770 = " file://nokia770_nand_fix.patch;patch=1"

S = "${WORKDIR}/linux-g"

SRC_URI[kernel.md5sum] = "8fb083c028ad66a3ebcc7d780e4d7f4d"
SRC_URI[kernel.sha256sum] = "afe5bddd14c06e1e9350742c5569511039ceaf82a2437b89a62c7ae8c82df245"
SRC_URI[ossopatch.md5sum] = "4610c31506e86b81323ce45465ec73eb"
SRC_URI[ossopatch.sha256sum] = "09e3fceea73bea972ce580232c5ca669836c892c6bfb303f8053463a2c534e93"
SRC_URI[rppatch25.md5sum] = "58f444edda4cc611236cfc2641905ca2"
SRC_URI[rppatch25.sha256sum] = "932760a92ad3b7bad483a9587dddf7784f9084676cfe7fbb2352681165b594d7"
SRC_URI[rppatch26.md5sum] = "397be20b7a23c6d540bd6cb05ed782b6"
SRC_URI[rppatch26.sha256sum] = "9fb2878799a6f80687bf5623a94cc96ba72272041f1a5f18fddf24831c4e3764"
SRC_URI[rppatch27.md5sum] = "7c4b0de088db249cd94ec0001c4d3edd"
SRC_URI[rppatch27.sha256sum] = "f91accabee3408cc318affb01b1dd764cad555441a2c8ee23c598880f5825807"
SRC_URI[rppatch28.md5sum] = "07ad218dee6afd77cf25092f8f10672f"
SRC_URI[rppatch28.sha256sum] = "ad0d651697da09d56645a53ece0b7037aae1ed0709ac3644bc15a6b0edc53668"
SRC_URI[rppatch29.md5sum] = "feb7a4252b3257e3a5b31fb60cfa8aff"
SRC_URI[rppatch29.sha256sum] = "c21877e59bb25d2d4061511da4386dcddeb99db885afe4ed50bc8b6e7d93d0bd"
