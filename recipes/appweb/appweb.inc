def get_appweb_host(d, bb):
    import re
    host = bb.data.getVar('HOST_SYS', d, 1)
    if(re.search('-linux-uclibc',host)):
        host = '-linux'
    return host
