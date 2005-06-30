#ident "@(#)policy.h	4.3 97/06/05 Copyright (c) Gert Doering"

/* this is the file where all configuration defaults for mgetty / sendfax
 * are specified.
 *
 * defaults are used if no values are given in the config file(s).
 * config file values can be overridden by command line options.
 *
 * see mgetty.texi/mgetty.info for a description of the configuration files.
 */

/* main mgetty configuration file
 */
#define MGETTY_CONFIG "mgetty.config"

/* sendfax configuration file
 *
 * if path doesn't start with "/", it's relative to CONFDIR (Makefile)
 * if not defined, no configuration file is read (saves a few kbytes)
 */
#define SENDFAX_CONFIG "sendfax.config"


/* login dispatcher config file (for mgetty)
 *
 * In this file, you can configure which "login" program (default /bin/login)
 * to call for what user name.
 *
 * You could use it to call "uucico" for all users starting with "U*"
 * (works only with Taylor UUCP 1.04 with my patch), or to call a fido
 * mailer for fido calls (only if -DFIDO defined)...
 * See the samples in the example login.config file (built from login.cfg.in).
 *
 * WARNING: make sure that this file isn't world-accessable (SECURITY!)
 *
 * If you want to call /bin/login in any case, do not define this
 *
 * If this doesn't start with "/", it's relative to CONFDIR.
 */
#define LOGIN_CFG_FILE "login.config"

/* default login program
 *
 * If LOGIN_CFG_FILE is not defined, or does not exist, or doesn't
 * have a default entry, this program is called for user logins.
 * Normally, this is "/bin/login", just a few systems put "login"
 * elsewhere (e.g. Free/NetBSD in "/usr/bin/login").
 */
#define DEFAULT_LOGIN_PROGRAM "/bin/login"


/* callback config file
 *
 * this file controls the operation of the optional "callback" program.
 * how callback works, is explained in detail in mgetty.texi. You need
 * to set LOGIN_CFG_FILE (see above) to use callback from mgetty. 
 *
 * If this path does not start with "/", it's relative to CONFDIR.
 */
#define CALLBACK_CONFIG "callback.config"


/* if this file exists, it can be used to control what callers
 * are allowed in.  If undefined, the functionality is omitted.
 * It will work only if your modem supports it. Check the modem manual.
 * For Rockwell-Based modems, add #CID=1 to MODEM_INIT_STRING, for
 * ZyXELs use S40.2=1.
 * If the path doesn't start with "/", it's relative to CONFDIR.
 */
#define CNDFILE "dialin.config"


/* If you want to use /etc/gettydefs to set tty flags, define this
 * I recommend against it, I suspect some bugs lingering in that code
 * (and one doesn't really need it in a normal setup anyway).
 */
/* #define USE_GETTYDEFS */

/* Name of the "gettydefs" file (used only if USE_GETTYDEFS is set)
 */
#define GETTYDEFS "/etc/gettydefs"

/* If no gettydefs "tag" is specified on the command line, use
 * this setting (from GETTYDEFS) as default (only if compiled with
 * USE_GETTYDEFS set)
 */
#define GETTYDEFS_DEFAULT_TAG "n"


/* access modes */

/* user id of the "uucp" user. The tty device will be owned by this user,
 * so parallel dial-out of uucico will be possible
 */
#define DEVICE_OWNER	"root"
/* group id that the device is chown()ed to. If not defined, the
 * primary group of "DEVICE_OWNER" is used.
 */
#define DEVICE_GROUP	"dialout"

/* access mode for the line while getty has it - it should be accessible
 * by uucp / uucp, but not by others (imagine someone dialing into your
 * system and using another modem to dial to another country...)
 */
#define FILE_MODE 0660

/* security: optionally, mgetty can system() this, to kill any dangling
 * processes on the current tty. A %s is replaced with the tty device.
 * NOT NEEDED on SCO, SunOS 4 or Linux!
 */
/* #define EXEC_FUSER "exec fuser -k -f %s >/dev/null 2>&1" */


/* logging */

/* system console - if a severe error happens at startup, mgetty writes
 * a message to this file and aborts
 * On SCO, this may be /dev/syscon!
 */
#define CONSOLE "/dev/console"

/* Name of the mgetty log file
 * e.g. "/usr/spool/log/mgetty.log.%s" or "/tmp/log_mg.%s"
 * a "%s" will be replaced by the device name, e.g. "tty2a"
 *
 * if the directory does not exist, the log file goes to CONSOLE (!)
 */
#define LOG_PATH "/var/log/mgetty/mg_%s.log"

/* Default log error level threshold. Possible error levels are
 * L_FATAL, L_ERROR, L_WARN, L_AUDIT, L_MESG, L_NOISE, L_JUNK (see mgetty.h)
 */
#define LOG_LEVEL L_MESG

/* Whether "\n"s in the modem response should start a new line
 * in the logfile
 */
/* #define LOG_CR_NEWLINE */

/* System administrator - if a severe error happens (lprintf called
 * with log_level L_FATAL) and writing to CONSOLE is not possible,
 * the logfile will be mailed to him
 */
#define ADMIN	"root"

/* Syslog
 *
 * If you want logging messages of type L_AUDIT, L_ERROR and L_FATAL
 * to go to the "syslog", define this.
 * mgetty will use the facility "LOG_AUTH", and the priorities
 * LOG_NOTICE, LOG_ERR and LOG_ALERT, respectively.
 */
#define SYSLOG 

/* Syslog facility
 *
 * This is the facility mgetty uses for logging. Ususally, this will be
 * LOG_AUTH, but on some systems, this may not exist, try LOG_DAEMON
 * instead (or look into the syslog manpage for available options)
 */
#define SYSLOG_FC LOG_AUTH

/* login stuff */

/* System name - printed at login prompt
 * If you do not define this, the uname() call will be used
 */
/* #define SYSTEM	"greenie" */

/* Login prompt
 * The "@", "\\D" and "\\T" escapes will be replaced by SYSTEM, the
 * current date and time, respectively.
 * override with "-p <prompt>" switch
 */
#define LOGIN_PROMPT	"@ login: "

/* On SVR4, maybe on other systems too, you can cause the 'login' program
 * to prompt with the same string as mgetty did, instead of the standard
 * "login:" prompt. The string will be passed to the 'login' program
 * in the environment variable TTYPROMPT.
 * This is done by putting "login" into a special (brain-dead) "ttymon"-
 * compatibility mode. In that mode, mgetty doesn't ask for a login name
 * at all, so mgetty won't work if you enable that feature and your
 * login program doesn't support it. (You can see if it doesn't work
 * if the user gets a double login prompt or none at all).
 *
 * This feature automatically disables FIDO and AutoPPP support!
 *
 * To use this feature, define ENV_TTYPROMPT.
 */
/* #define ENV_TTYPROMPT */

/* Maximum time before login name has to be entered (in seconds)
 * (after that time a warning will be issued, after that, the call is
 * dropped). To disable that feature, do not define it.
 */
#define MAX_LOGIN_TIME	240

/* nologin file
 *
 * If that file exists, a ringing phone won't be answered (see manual).
 * "%s" will be replaced by the device name.
 */
#define NOLOGIN_FILE "/etc/nologin.%s"


/* misc */

/* how to find mgetty..
 *
 * If you define this, mgetty will create a file with the given name and
 * put its process ID in it. A "%s" will be replaced by the device id.
 *
 * Depending on your system, "/var/run/mgetty.%d" might be a good place.
 */
#define MGETTY_PID_FILE	"/var/run/mg-pid.%s"

/* Path for the lock files. A %s will be replaced with the device name,
 * e.g. tty2a -> /usr/spool/uucp/LCK..tty2a
 * Make sure that this is the same file that your uucico uses for
 * locking!
 */

/* for a few systems, you can just take those defaults and be happy */
#if defined (SVR4) || defined(sunos4)
# define LOCK_PATH "/var/spool/locks"
# define LOCK      "/var/spool/locks/LCK..%s"
#else
# ifdef sgi
#  define LOCK	"/usr/spool/locks/LCK..%s"
# endif
# ifdef _AIX
#  define LOCK	"/etc/locks/LCK..%s"
# endif
# ifdef NeXT
#  define LOCK "/usr/spool/uucp/LCK/LCK..%s"
# endif
# ifdef linux
#  define LOCK	"/var/lock/LCK..%s"
# endif
#endif

/* if your system isn't listed above, change that line here */
#ifndef LOCK
#define LOCK "/var/lock/LCK..%s"
#endif
  
/* Set this to "1" if your system uses binary lock files (i.e., the pid
 * as four byte integer in host byte order written to the lock file)
 * If it is "0", HDB locking will be used - the PID will be written as
 * 10 byte ascii, with a trailing newline
 * (Just check "LOCK" while uucico or pcomm or ... are running to find
 * out what lock files are used on your system)
 * On NeXT systems, you must set this to "1".
 */
#define LOCKS_BINARY 0

/* Lower case locks - change the last character of the device name
 *                    to lowercase for locking purposes.
 *
 * If you're using a SCO Unix system with those "tty1a/tty1A" device
 * pairs, you'll have to define this.
 */
/* #define LOCKS_LOWERCASE */

/* Change _all_ characters to lowercase (currently no system uses this) */
/* #define LOCKS_ALL_LOWERCASE */


/* the default speed used by mgetty - override it with "-s <speed>"
 *
 * WARNING: this is a bit tricky, since some modems insist on going to
 * 19200 bps when in fax mode. So, if fax receiving with a port speed of
 * something else doesn't work, try experimenting with FAX_RECV_SWITCHBD,
 * and if that doesn't help, try DEFAULT_PORTSPEED 19200
 *
 * WARNING2: Speeds higher than 38400 aren't supported on all platforms,
 * and sometimes you have to use "50" to get 57600 or so!
 */
#define DEFAULT_PORTSPEED	38400

/* the modem initialization string
 *
 * the default string should set up most hayes compatible modems into a
 * fairly sane state (echo on, verbose reports on, quiet off, reset on
 * DTR toggle on), but it doesn't set any flow control options (because
 * that's done differently on each modem, look into your manual for commands
 * like &H3, &K4, \Q6 or similar things) or protocols.
 *
 * You can change the initialization sequence with the "init-chat" keyword
 * in "mgetty.config".
 *
 * If you need delays, specify them as "\\d", if you want to send a
 * backslash ('\'), give it as "\\\\".
 *
 * Very IMPORTANT: make sure that the modem assigns the DCD line properly,
 * usually this is done with the AT&C1 command!
 *
 * The modem must answer with "OK" (!!!) - otherwise, use "init-chat".
 */
#define MODEM_INIT_STRING	"AT"

/* command termination string
 *
 * for most modems, terminating the AT... command with "\r" is
 * sufficient and "\r\n" also works without doing harm.
 * Unfortunately, for the Courier HST, you've to use *only* \r,
 * otherwise ATA won't work (immediate NO CARRIER), and for some
 * (old) ZyXELs, you have to use \r\n (no OK otherwise).
 * So, try one, and if it doesn't work, try the other.
 */
#define MODEM_CMD_SUFFIX "\r"

/* "keep alive"
 *
 * mgetty can periodically check whether the modem is still alive
 * by issueing an "AT\r" command and checking for the "OK"
 * Define here, in seconds, how often mgetty should check. For normal
 * reliable modems, once an hour should be sufficient...
 * If you use "-1", or don't define this at all, mgetty won't check.
 */
#define MODEM_CHECK_TIME 3600


/* modem mode
 *
 * DEFAULT_MODEMTYPE specifies the default way mgetty+sendfax handle a
 * faxmodem. You have four choices:
 *   "data" - data only, no faxing available (for sendfax, equal to "auto")
 *   "cls2" - use AT+FCLASS=2
 *   "c2.0" - use AT+FCLASS=2.0
 *   "auto" - try "2.0", then "2", then fall to "data".
 *
 * Normally, you can leave this to "auto", but if you have a modem that
 * can do class 2.0 and class 2, and 2.0 doesn't work, then you could try
 * setting it to "cls2".
 * You can override this define with the "-C <mode>" switch.
 */
#define DEFAULT_MODEMTYPE "auto"


/* some modems are a little bit slow - after sending a response (OK)
 * to the host, it will take some time before they can accept the next
 * command - specify the amount needed in data mode here (in
 * milliseconds). Normally, 50 ms should be sufficient. (On a slow
 * machine it may even work without any delay at all)
 *
 * Be warned: if your machine isn't able to sleep for less than one
 * second, this may cause problems.
 */
#define DO_CHAT_SEND_DELAY 50
 /* and this is the delay before sending each command while in fax mode
  */
#define FAX_COMMAND_DELAY 50

/* incoming faxes will be chown()ed to this uid and gid.
 * if FAX_IN_GROUP is undefined, the group of ...OWNER is used.
 */
#define FAX_IN_OWNER	"root"
#define FAX_IN_GROUP	"fax"

/* incoming faxes will be chmod()ed to this mode
 * (if you do not define this, the file mode will be controlled by
 * mgetty's umask)
 */
#define FAX_FILE_MODE 0660

/* FLOW CONTROL
 *
 * There are basically two types of flow control:
 * - hardware flow control: pull the RTS/CTS lines low to stop the other
 *   side from spilling out data too fast
 * - sofware flow control: send an Xoff-Character to tell the other
 *   side to stop sending, send an Xon to restart
 * obviously, use of Xon/Xoff has the disadvantage that you cannot send
 * those characters in your data anymore, but additionally, hardware flow
 * control is normally faster and more reliable
 *
 * mgetty can use multiple flow control variants:
 * FLOW_NONE  - no flow control at all (absolutely not recommended)
 * FLOW_HARD  - use RTS/CTS flow control (if available on your machine)
 * FLOW_SOFT  - use Xon/Xoff flow control, leave HW lines alone
 * FLOW_BOTH  - use both types simultaneously, if possible
 *
 * Note that few operating systems allow both types to be used together.
 *
 * mgetty won't (cannot!) notice if your settings don't work, but you'll
 * see it yourself: you'll experience character losses, garbled faxes,
 * low data throughput,..., if the flow control settings are wrong
 *
 * If in doubt what to use, try both and compare results.
 * (if you use FAS or SAS with the recommended settings, FLOW_HARD is a
 * "don't care" since the driver will use RTS/CTS anyway)
 *
 * If you use an atypical system, check whether tio_set_flow_control in
 * tio.c does the right thing for your system.
 */

/* This is the flow control used for normal data (login) connections
 * Set it to FLOW_HARD except in very special cases.
 */
#define DATA_FLOW	FLOW_HARD

/* This is the flow control used for incoming fax connections
 * Wrong settings will result in missing lines or erroneous lines
 * in most of the received faxes.
 * Most faxmodems expect Xon/Xoff, few honour the RTS line.
 */
#define FAXREC_FLOW	FLOW_HARD | FLOW_SOFT

/* And this is for sending faxes
 *
 * Wrong settings here will typically result in that the first few
 * centimeters of a transmitted fax look perfect, and then (the buffer
 * has filled up), the rest is more or less illegible junk.
 * For most faxes, this has to be FLOW_SOFT, though the Supra and ZyXEL
 * modems will (sometimes) do hardware flow control, too. Try it.
 *
 * If you see a large number of [11] and [13] characters in the sendfax
 * log file, your modem is propably doing software flow control - and
 * you've definitely set FAXSEND_FLOW to FLOW_HARD...
 *
 * Some versions of SCO Unix have a "weird" serial driver that will only
 * do half duplex hardware flow control. You will then run into the problem
 * that fax sending will time out after the first page sent (no ACK received)
 * and fail if FLOW_HARD is used. Use FLOW_SOFT instead.
 */
#define FAXSEND_FLOW	FLOW_HARD | FLOW_SOFT
 
/* if your faxmodem switches port bit rate just after sending the "+FCON"
 * message to the host, define this to contain the baudrate used. (Not
 * important if you have the portspeed set to this value anyway).
 *
 * Most Rockwell-based modems need FAX_RECV_SWITCHBD 19200.
 * ZyXELs do *not* need this, except if explicitely told to do so.
 *
 * You can see if this is set wrong if mgetty gets the "+FCON" response,
 * starts the fax receiver, and times out waiting for OK, receiving
 * nothing or just junk.
 */
/* #define FAX_RECV_SWITCHBD 19200 */

/* some genius at US Robotics obviously decided that the above method
 * of switching baud rates is broken, and came up with something new
 * --- broken as well (why bother switching rates at all?) --- this
 * and other USR Courier Fax follies will be handled by enabling the
 * following define (if you have an USR faxmodem that does *not* need
 * this, please send me a mail!)
 * It seems as if the newest V.34 modems do not need this anymore, please
 * try it out...
 */
/* #define FAX_USRobotics */

/* name of the logfile for outgoing faxes (e.g. /var/log/sendfax.log)
 */
#define FAX_LOG		"/var/log/mgetty/fax/sendfax.log"

/* local station ID (your fax number)
 * 20 character string, most faxmodem allow all ascii characters 32..127,
 * but some do only allow digits and blank
 * AT+FLID=? should tell you what's allowed and what not.
 */
#define FAX_STATION_ID	" "

/* ------ sendfax-specific stuff follows here -------- */

/* the baudrate used for *sending* faxes. ZyXELs can handle 38400,
 * SUPRAs (and many other rockwell-based faxmodems) can not.
 * I recommend 38400, since 19200 may be to slow for 14400 bps faxmodems!
 */
#define FAX_SEND_BAUD 38400

/* switch baud rate after +FCLASS=2
 *
 * some weird modems require that you initialize the modem with one
 * baud rate (e.g. 2400 or 9600 for cheap 2400+fax modems, or `smart'
 * modems that insist on staying locked to 38400 (ELSA!)), but switch
 * to another baud rate, typically 19200, immediately after receiving
 * the "AT+FCLASS=2" command.
 *
 * If the following is defined, sendfax will switch to the speed given
 * here after sending AT+FCLASS=2.
 *
 * Only try fiddling with this if sendfax times out during modem
 * initialization, receiving junk instead of "OK" or "ERROR" (logfile!)
 */
/* #define FAX_SEND_SWITCHBD 19200 */

/* this is the command to set the modem to use the desired flow control.
 * For hardware handshake, this could be AT&H3 for the ZyXEL, &K3 for
 * Rockwell-Based modems or AT\\Q3&S0 for Exar-Based Modems (i.e. some GVC's)
 * If you don't want extra initalization, do not define it.
 * Don't forget the "AT"!
 */
/* #define FAX_MODEM_HANDSHAKE "AT&H3" */

/* This is the modem command used for dialing. The phone number will
 * get appended right after the string. Normally, "ATD" or "ATDP" should
 * suffice, but in some situations (company telephone systems) you might
 * need something like "ATx0DT0wP" (switch of dial-tone recognition, tone-
 * dial a "0", wait for dial-tone, pulse dial the rest)
 */
#define FAX_DIAL_PREFIX "ATD"

/* When sending a fax, if the other side says "page bad, retrain
 * requested", sendfax will retry the page. Specifiy here the maximum
 * number of retries (I recommend 3) before hanging up.
 *
 * If you set it to "0", sendfax will *never* retransmit a page (only
 * do this if you know that your modem returns +FPTS:2 even if the
 * page arrived properly, but be warned - you wont' be able to react
 * properly to transmission errors!)
 *
 * See also the description of the "max-tries" and "max-tries-continue"
 * settings in the sendfax config file.
 */
#define FAX_SEND_MAX_TRIES 3

/* the device(s) used for faxing
 * multiple devices can be separated by ":", e.g. "tty1a:tty2a"
 * (with or without leading /dev/)
 * If you don't adapt this for your needs, sendfax won't run (you can
 * set it from the sendfax.config file, though)!
 */
#define FAX_MODEM_TTYS	"ttyS1"

/* some modems, notably some GVC modems, all USR models, and the german
 * telecom approved ZyXEL EG+ have the annoying behaviour of lowering
 * and raising the DCD line during the pre- and post-page handshake
 * (when sending faxes).
 *
 * If your modem does this, sendfax will terminate immediately after
 * starting to send the first page, or between the first and second
 * page, and the fax log file will show something like
 * "read failed, I/O error".
 *
 * If you define this, sendfax will (try to) ignore that line
 */

/* #define FAX_SEND_IGNORE_CARRIER */

/* Xon or not?
 *
 * the first issues of the class 2 drafts required that the program waits
 * for an Xon character before sending the page data. Later versions
 * removed that. Sendfax can do both, default is to wait for it.
 *
 * If you get an error message "... waiting for XON" when trying to
 * send a fax, try this one. Some ELSA modems are know to need it.
 */
/* #define FAXSEND_NO_XON */


/* define mailer that accepts destination on command line and mail text
 * on stdin. For mailers with user friendly interfaces, (such as mail,
 * mailx, elm), include an appropriate subject line in the command
 * definition. If using a mail agent (such as sendmail), that reads
 * mail headers, define NEED_MAIL_HEADERS.
 */
#ifdef SVR4
# define MAILER		"/usr/bin/mailx -s 'Incoming facsimile message'"
#else
# ifdef _AIX
#  define MAILER	"/usr/sbin/sendmail"
#  define NEED_MAIL_HEADERS
# endif
# ifdef M_UNIX		/* SCO */
#  define MAILER	"/usr/lib/mail/execmail"
#  define NEED_MAIL_HEADERS
# endif
#endif

#ifndef MAILER
# define MAILER		"/usr/sbin/sendmail"
# define NEED_MAIL_HEADERS
#endif

/* where to send notify mail about incoming faxes to
 * (remember to create an mail alias if no such user exists!)
 */
#define MAIL_TO		"root"

/* after a fax has arrived, mgetty can call a program for further
 * processing of this fax.
 *
 * (e.g.: printing of the fax, sending as MIME mail, displaying in an X
 * window (the latter one could be tricky) ...)
 *
 * It will be called as:
 * <program> <result code> "<sender_id>" <#pgs> <pg1> <pg2>...
 * 
 * Define the name of this program here
 * If you don't want this type of service, do not define it at all
 * Absolute path name has to be used here!
 */
#define FAX_NOTIFY_PROGRAM "/etc/mgetty/new_fax"

/* default minimum space required on spooling partition for receiving a FAX
 * (in KILObytes)
 */
#define	MINFREESPACE 1024

