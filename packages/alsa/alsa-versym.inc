
def get_alsa_versym_setting(bb, d):
    # Versioned symbols don't work propery with uClibc
    if bb.data.getVar('TARGET_OS', d, 1).find('uclibc') >= 0:
        return "--with-versioned=no"
    return ""
