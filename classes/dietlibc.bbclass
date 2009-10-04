DEPENDS =+ "dietlibc"

def dietlibc_after_parse(d):
    import bb
    # Remove the NLS
    cfg = oe_filter_out('--(dis|en)able-nls', bb.data.getVar('EXTRA_OECONF', d, 1) or "", d)
    # Remove shared enable static only
    cfg += " --disable-nls --disable-shared --enable-static"
    bb.data.setVar('EXTRA_OECONF', cfg, d)
    cfg = bb.data.getVar('EXTRA_OEMAKE', d, 1) or ""
    cfg = oe_filter_out("\'CC=", bb.data.getVar('EXTRA_OEMAKE', d, 1) or "", d)
    cfgtmp = "\'CC=\"diet ${CCACHE}\""
    cfgtmp += cfg
    bb.data.setVar('EXTRA_OEMAKE', cfgtmp, d)

#python () {
#    dietlibc_after_parse(d)
#}

set_dietlibc_env () {
	export CC="diet ${CC}"
}

do_compile_prepend() {
    set_dietlibc_env
}

do_configure_prepend() {
    set_dietlibc_env
}
