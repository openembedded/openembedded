DESCRIPTION = "TI XDC tool"

# This file defines function used for extracting .bin file

python do_unpack () {
    bb.build.exec_func('base_do_unpack', d)
    bb.build.exec_func('ti_bin_do_unpack', d)
}

python ti_bin_do_unpack() {

    import os

    localdata = bb.data.createCopy(d)
    bb.data.update_data(localdata)

    binfile  = bb.data.getVar('BINFILE', localdata)

    # Change to the working directory
    save_cwd = os.getcwd()
    workdir  = bb.data.getVar('WORKDIR', localdata)
    workdir  = bb.data.expand(workdir, localdata)
    os.chdir(workdir)

    # Make the InstallJammer binary executable so we can run it
    os.chmod(binfile, 0755)

    # Run the InstallJammer binary and accept the EULA
    filename = "HOME=%s ./%s" % (workdir, binfile)
    f = os.popen(filename,'w')
    print >>f, "Y\n"
    print >>f, " qY\n"
    print >>f, "%s\n" % workdir
    print >>f, "Y\n"
    f.close()

    # Return to the previous directory
    os.chdir(save_cwd)
}

