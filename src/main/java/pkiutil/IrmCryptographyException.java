package pkiutil;

public class IrmCryptographyException extends IrmException
{
	private static final long serialVersionUID = 3L;

	public IrmCryptographyException()
	{
        super();
    }

    public IrmCryptographyException(String message)
    {
        super(message);
    }

    public IrmCryptographyException(Throwable cause)
    {
        super(cause);
    }
    
    public IrmCryptographyException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
