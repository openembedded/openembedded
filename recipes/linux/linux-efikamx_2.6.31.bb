require linux.inc

DESCRIPTION = "Linux kernel for EfikaMX platform"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "efikamx"
DEFAULT_PREFERENCE = "1"
python do_unpack () {
       bb.build.exec_func('efikamx_kernel_do_unpack', d)
}

efikamx_kernel_do_unpack () {
       mkdir -p ${S}
       tar xf ${DL_DIR}/${PN}-${PV}.tar.lzma --strip-components=1 -C ${S}
       tar xf ${DL_DIR}/patch-${PV}.tar.lzma -C ${S}
       (cd ${S}/patches; ln -s ${FILESPATHBASE}/${PN}-${PV}/remove-localversion.patch .)
}

python do_patch () {
       bb.build.exec_func('efikamx_kernel_do_patch', d)
}

efikamx_kernel_do_patch (){
       ( cd ${S}/patches; ls *.patch >series;cp *.config ${S}/../defconfig)
       ( cd ${S}; quilt push -a)
}


SRC_URI += "http://sources.openembedded.org/${P}.tar.lzma;name=kernel \
            http://sources.openembedded.org/patch-${PV}.tar.lzma;name=patch \
	    file://remove-localversion.patch;apply=no \
           "

SRC_URI[kernel.md5sum] = "c70ce0549cf85de79d5b28db7b552868"
SRC_URI[kernel.sha256sum] = "658395072352cd38477d80c105f00d824c73bf437f0843579d1e0bf41066617f"
SRC_URI[patch.md5sum] = "6c04416bce74dd413f3e82cd17378419"
SRC_URI[patch.sha256sum] = "5c15cffa02089d286fc07ba734b1f33a81d1f7ceaf70e596bd8b82ddd5e73ec2"
