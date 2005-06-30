def base_tinder_time():
    import time
    return time.strftime('%m/%d/%Y %H:%M:%S', time.localtime())

# Prepare tinderbox mail header
def base_prepare_mail_header(data, status):
    import bb

    str  = "tinderbox: administrator: %s\n" % bb.data.getVar('TINDER_ADMIN', data, True)
    str += "tinderbox: starttime: %s\n"     % bb.data.getVar('TINDER_START', bb.make.cfg, True)
    str += "tinderbox: buildname: %s\n"     % bb.data.getVar('TINDER_BUILD', data, True)
    str += "tinderbox: errorparser: %s\n"   % bb.data.getVar('TINDER_ERROR', data, True)
    str += "tinderbox: status: %s\n"        % status
    str += "tinderbox: timenow: %s\n"       % base_tinder_time()
    str += "tinderbox: tree: %s\n"          % bb.data.getVar('TINDER_TREE', data, True)
    str += "tinderbox: buildfamily: %s\n"   % "unix"
    str += "tinderbox: END"

    return str

def base_do_tinder_report(event):
    """
    Report to the tinderbox. Either we will report every step
    (depending on TINDER_VERBOSE_REPORT) at the end we will send the
    tinderclient.log
    """
    from bb.event import getName
    from bb import data, make, mkdirhier
    import os, glob

    # variables
    name = getName(event)
    log  = ""
    header = ""
    verbose = data.getVar('TINDER_VERBOSE_REPORT', event.data, True) == "1"

    # Check what we need to do Build* shows we start or are done
    if name == "BuildStarted":
        data.setVar('TINDER_START', base_tinder_time(), event.data)
        header = base_prepare_mail_header(event.data, 'building')
        # generate
        for var in os.environ:
            log += "%s=%s\n" % (var, os.environ[var])

        mkdirhier(data.getVar('TMPDIR', event.data, True))
        file = open(data.getVar('TINDER_LOG', event.data, True), 'w')
        file.write(log)

        if not verbose:
            header = ""

    if name == "PkgFailed" or name == "BuildCompleted":
        status = 'build_failed'
            if name == "BuildCompleted":
                status = "success"
            header = base_prepare_mail_header(event.data, status)
            # append the log
            log_file = data.getVar('TINDER_LOG', event.data, True)
            file     = open(log_file, 'r')
            for line in file.readlines():
                log += line

    if verbose and name == "TaskStarted":
        header = base_prepare_mail_header(event.data, 'building')
        log    = "Task %s started" % event.task

    if verbose and name == "PkgStarted":
        header = base_prepare_mail_header(event.data, 'building')
        log    = "Package %s started" % data.getVar('P', event.data, True)

    if verbose and name == "PkgSucceeded":
        header = base_prepare_mail_header(event.data, 'building')
        log    = "Package %s done" % data.getVar('P', event.data, True)

    # Append the Task Log
    if name == "TaskSucceeded" or name == "TaskFailed":
        log_file = glob.glob("%s/log.%s.*" % (data.getVar('T', event.data, True), event.task))

        if len(log_file) != 0:
            to_file  = data.getVar('TINDER_LOG', event.data, True)
            log_txt  = open(log_file[0], 'r').readlines()
            to_file  = open(to_file, 'a')

            to_file.writelines(log_txt)

            # append to the log
            if verbose:
                header = base_prepare_mail_header(event.data, 'building')
                for line in log_txt:
                    log += line

    # now mail the log
    if len(log) == 0 or len(header) == 0:
        return

    import smtplib
    from email.MIMEText import MIMEText
    msg = MIMEText(header +'\n' + log)
    msg['Subject'] = "Tinder-Client build log"
    msg['To']      = data.getVar('TINDER_MAILTO',event.data, True)
    msg['From']    = data.getVar('TINDER_FROM',  event.data, True)


    s = smtplib.SMTP()
    s.connect()
    s.sendmail(data.getVar('TINDER_FROM', event.data, True), [data.getVar('TINDER_MAILTO', event.data, True)], msg.as_string())
    s.close()

addhandler tinderclient_eventhandler
python base_eventhandler() {

    do_tinder_report = data.getVar('TINDER_REPORT', e.data, True)
    if do_tinder_report and do_tinder_report == "1":
        base_do_tinder_report(e)

    return NotHandled
}
