DEPENDS =+ "gettext-native virtual/libiconv virtual/libintl"
EXTRA_OECONF += "--enable-nls"

def gettext_after_parse(d):
    import bb
    # Remove the NLS bits if USE_NLS is no.
    if bb.data.getVar('USE_NLS', d, 1) == 'no':
        cfg = oe_filter_out('^--(dis|en)able-nls$', bb.data.getVar('EXTRA_OECONF', d, 1) or "", d)
        cfg += " --disable-nls"
        bb.data.setVar('EXTRA_OECONF', cfg, d)
        depends = bb.data.getVar('DEPENDS', d, 1) or ""
        bb.data.setVar('DEPENDS', oe_filter_out('^(gettext-native|virtual/libiconv|virtual/libintl)$', depends, d), d)

python () {
    gettext_after_parse(d)
}
