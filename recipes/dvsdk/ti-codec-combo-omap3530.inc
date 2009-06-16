# This file defines function used for unpacking the .bin file downloaded over
# the http and display EULA.
#  BINFILE - name of the install jammer .bin file
#  TARFILE - name of the tar file inside the install jammer

python do_unpack () {
    bb.build.exec_func('base_do_unpack', d)
    bb.build.exec_func('ti_bin_do_unpack', d)
}

python ti_bin_do_unpack() {

    import os

    localdata = bb.data.createCopy(d)
    bb.data.update_data(localdata)

    binfile  = bb.data.getVar('BINFILE', localdata)
    tarfile  = bb.data.getVar('TARFILE', localdata)

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
    f.close()

    # Expand the tarball that was created
    cmd = 'tar xz --no-same-owner -f %s -C %s' % (tarfile, workdir)
    ret = os.system(cmd)

    # Return to the previous directory
    os.chdir(save_cwd)
    return ret == 0
}

