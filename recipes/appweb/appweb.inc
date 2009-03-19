def get_appweb_host(d, bb):
    host = bb.data.getVar('HOST_SYS', d, 1)
    return host.replace('-linux-uclibc', '-linux')

