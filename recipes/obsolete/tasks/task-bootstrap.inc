def bootstrap_modutils_rdepends(d):
    import bb
    m = bb.data.getVar('MODUTILS', d, 1)
    r = []
    if '24' in m:
        r.append('modutils-depmod')
    if '26' in m:
        r.append('module-init-tools-depmod')
    return ' '.join(r)
