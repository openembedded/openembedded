require glibc_${PV}.bb
require glibc-initial.inc

do_configure_prepend () {
	unset CFLAGS
}

SRC_URI[md5sum] = "fc62e989cf31d015f31628609fc3757a"
SRC_URI[sha256sum] = "098baa84c74af5b21d27ec6e8ba6f1a393de88327cefbcd9e90c9b4edda9a36c"
SRC_URI[md5sum] = "7d5d86031cb15403e4d246658209ee81"
SRC_URI[sha256sum] = "824c97b83f1ec2894ee0e824db6d542c40b978d2f6c4364c7411777e44b15a64"
SRC_URI[md5sum] = "99536b508af988e7cc6275944d12b491"
SRC_URI[sha256sum] = "27ac255ee701036191118f7a6a4191b24741f5909dccfc9eec4ab611a39e182f"
