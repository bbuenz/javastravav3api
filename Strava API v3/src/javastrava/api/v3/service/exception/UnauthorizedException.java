package javastrava.api.v3.service.exception;

import javastrava.api.v3.model.StravaResponse;

/**
 * <p>
 * Thrown when the Strava API returns an HTTP status of 401 Unauthorised
 * </p>
 * 
 * @author Dan Shannon
 *
 */
public class UnauthorizedException extends RuntimeException implements StravaAPIException  {

	/**
	 * Default
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Response from Strava API containing error details
	 */
	private StravaResponse	response;

	/**
	 * @param status Status message
	 * @param response the Strava error message
	 * @param cause The underlying cause of the exception
	 */
	public UnauthorizedException(final String status, final StravaResponse response, final Throwable cause) {
		super(status + " : " + (response == null ? "" : response.toString()),cause); //$NON-NLS-1$ //$NON-NLS-2$
		this.response = response;
	}
	
	/**
	 * @param reason The error message
	 */
	public UnauthorizedException(final String reason) {
		super(reason);
	}

	/**
	 * @see javastrava.api.v3.service.exception.StravaAPIException#getResponse()
	 */
	@Override
	public StravaResponse getResponse() {
		return this.response;
	}

	/**
	 * @see javastrava.api.v3.service.exception.StravaAPIException#setResponse(javastrava.api.v3.model.StravaResponse)
	 */
	@Override
	public void setResponse(final StravaResponse response) {
		this.response = response;
		
	}

}
