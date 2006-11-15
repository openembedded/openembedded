python __anonymous() {
    from bb import which, data
	
    path = data.getVar('PATH', d)
    if len(which(path, 'gcc-3.4')) != 0:
        data.setVar('EXTRA_OECONF', " --cc=gcc-3.4 --disable-gfx-check", d)
    elif len(which(path, 'gcc34')) != 0:
        data.setVar('EXTRA_OECONF', " --cc=gcc34 --disable-gfx-check", d)
    elif len(which(path, 'gcc33')) != 0:
        data.setVar('EXTRA_OECONF', " --cc=gcc33 --disable-gfx-check", d)
    elif len(which(path, 'gcc-3.3')) != 0:
        data.setVar('EXTRA_OECONF', " --cc=gcc-3.3 --disable-gfx-check", d)
    elif len(which(path, 'gcc-3.3.6')) != 0:
        data.setVar('EXTRA_OECONF', " --cc=gcc-3.3.6 --disable-gfx-check", d)
    elif len(which(path, 'gcc32')) != 0:
        data.setVar('EXTRA_OECONF', " --cc=gcc32 --disable-gfx-check", d)

}
