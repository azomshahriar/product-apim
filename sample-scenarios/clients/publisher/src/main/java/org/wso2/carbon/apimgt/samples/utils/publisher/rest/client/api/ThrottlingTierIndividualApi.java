/*
 * WSO2 API Manager - Publisher API
 * This specifies a **RESTful API** for WSO2 **API Manager** - Publisher.  Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.1.66/components/apimgt/org.wso2.carbon.apimgt.rest.api.publisher/src/main/resources/publisher-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification. 
 *
 * OpenAPI spec version: 0.11.0
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.api;

import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiCallback;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiClient;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiException;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiResponse;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.Configuration;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.Pair;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ProgressRequestBody;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.Error;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.Tier;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.TierPermission;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThrottlingTierIndividualApi {
    private ApiClient apiClient;

    public ThrottlingTierIndividualApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ThrottlingTierIndividualApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for tiersTierLevelTierNameDelete */
    private com.squareup.okhttp.Call tiersTierLevelTierNameDeleteCall(String tierName, String tierLevel, String ifMatch, String ifUnmodifiedSince, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/tiers/{tierLevel}/{tierName}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "tierName" + "\\}", apiClient.escapeString(tierName.toString()))
        .replaceAll("\\{" + "tierLevel" + "\\}", apiClient.escapeString(tierLevel.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (ifMatch != null)
        localVarHeaderParams.put("If-Match", apiClient.parameterToString(ifMatch));
        if (ifUnmodifiedSince != null)
        localVarHeaderParams.put("If-Unmodified-Since", apiClient.parameterToString(ifUnmodifiedSince));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call tiersTierLevelTierNameDeleteValidateBeforeCall(String tierName, String tierLevel, String ifMatch, String ifUnmodifiedSince, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'tierName' is set
        if (tierName == null) {
            throw new ApiException("Missing the required parameter 'tierName' when calling tiersTierLevelTierNameDelete(Async)");
        }
        
        // verify the required parameter 'tierLevel' is set
        if (tierLevel == null) {
            throw new ApiException("Missing the required parameter 'tierLevel' when calling tiersTierLevelTierNameDelete(Async)");
        }
        
        
        com.squareup.okhttp.Call call = tiersTierLevelTierNameDeleteCall(tierName, tierLevel, ifMatch, ifUnmodifiedSince, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete a Tier
     * This operation can be used to delete an existing tier. The only supported tier level is &#x60;api&#x60; tiers. &#x60;DELETE https://127.0.0.1:9443/api/am/publisher/v0.14/tiers/api/Low&#x60;  **IMPORTANT:** * This is only effective when Advanced Throttling is disabled in the Server. If enabled, we need to use Admin REST API for throttling tiers modification related operations.
     * @param tierName Tier name  (required)
     * @param tierLevel List API or Application or Resource type tiers.  (required)
     * @param ifMatch Validator for conditional requests; based on ETag (Will be supported in future).  (optional)
     * @param ifUnmodifiedSince Validator for conditional requests; based on Last Modified header (Will be supported in future).  (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void tiersTierLevelTierNameDelete(String tierName, String tierLevel, String ifMatch, String ifUnmodifiedSince) throws ApiException {
        tiersTierLevelTierNameDeleteWithHttpInfo(tierName, tierLevel, ifMatch, ifUnmodifiedSince);
    }

    /**
     * Delete a Tier
     * This operation can be used to delete an existing tier. The only supported tier level is &#x60;api&#x60; tiers. &#x60;DELETE https://127.0.0.1:9443/api/am/publisher/v0.14/tiers/api/Low&#x60;  **IMPORTANT:** * This is only effective when Advanced Throttling is disabled in the Server. If enabled, we need to use Admin REST API for throttling tiers modification related operations.
     * @param tierName Tier name  (required)
     * @param tierLevel List API or Application or Resource type tiers.  (required)
     * @param ifMatch Validator for conditional requests; based on ETag (Will be supported in future).  (optional)
     * @param ifUnmodifiedSince Validator for conditional requests; based on Last Modified header (Will be supported in future).  (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> tiersTierLevelTierNameDeleteWithHttpInfo(String tierName, String tierLevel, String ifMatch, String ifUnmodifiedSince) throws ApiException {
        com.squareup.okhttp.Call call = tiersTierLevelTierNameDeleteValidateBeforeCall(tierName, tierLevel, ifMatch, ifUnmodifiedSince, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete a Tier (asynchronously)
     * This operation can be used to delete an existing tier. The only supported tier level is &#x60;api&#x60; tiers. &#x60;DELETE https://127.0.0.1:9443/api/am/publisher/v0.14/tiers/api/Low&#x60;  **IMPORTANT:** * This is only effective when Advanced Throttling is disabled in the Server. If enabled, we need to use Admin REST API for throttling tiers modification related operations.
     * @param tierName Tier name  (required)
     * @param tierLevel List API or Application or Resource type tiers.  (required)
     * @param ifMatch Validator for conditional requests; based on ETag (Will be supported in future).  (optional)
     * @param ifUnmodifiedSince Validator for conditional requests; based on Last Modified header (Will be supported in future).  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call tiersTierLevelTierNameDeleteAsync(String tierName, String tierLevel, String ifMatch, String ifUnmodifiedSince, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = tiersTierLevelTierNameDeleteValidateBeforeCall(tierName, tierLevel, ifMatch, ifUnmodifiedSince, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for tiersTierLevelTierNameGet */
    private com.squareup.okhttp.Call tiersTierLevelTierNameGetCall(String tierName, String tierLevel, String accept, String ifNoneMatch, String ifModifiedSince, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/tiers/{tierLevel}/{tierName}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "tierName" + "\\}", apiClient.escapeString(tierName.toString()))
        .replaceAll("\\{" + "tierLevel" + "\\}", apiClient.escapeString(tierLevel.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (accept != null)
        localVarHeaderParams.put("Accept", apiClient.parameterToString(accept));
        if (ifNoneMatch != null)
        localVarHeaderParams.put("If-None-Match", apiClient.parameterToString(ifNoneMatch));
        if (ifModifiedSince != null)
        localVarHeaderParams.put("If-Modified-Since", apiClient.parameterToString(ifModifiedSince));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call tiersTierLevelTierNameGetValidateBeforeCall(String tierName, String tierLevel, String accept, String ifNoneMatch, String ifModifiedSince, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'tierName' is set
        if (tierName == null) {
            throw new ApiException("Missing the required parameter 'tierName' when calling tiersTierLevelTierNameGet(Async)");
        }
        
        // verify the required parameter 'tierLevel' is set
        if (tierLevel == null) {
            throw new ApiException("Missing the required parameter 'tierLevel' when calling tiersTierLevelTierNameGet(Async)");
        }
        
        
        com.squareup.okhttp.Call call = tiersTierLevelTierNameGetCall(tierName, tierLevel, accept, ifNoneMatch, ifModifiedSince, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get details of a tier
     * This operation can be used to retrieve details of a single tier by specifying the tier level and tier name. Note that the scope of the API is mandatory while retreiving the access token with the following cURL command : &#x60;curl -k -d \\\&quot;grant_type&#x3D;password&amp;username&#x3D;username&amp;password&#x3D;password&amp;scope&#x3D;apim:tier_view\\\&quot; -H \\\&quot;Authorization: Basic &lt;token&gt;\\\&quot; https://127.0.0.1:8243/token&#x60;. You will receive the access token as the response, for example &#x60;\&quot;access_token\&quot;:\&quot;8644c013-7ff1-3217-b150-d7b92cae6be7\&quot;&#x60;. 
     * @param tierName Tier name  (required)
     * @param tierLevel List API or Application or Resource type tiers.  (required)
     * @param accept Media types acceptable for the response. Default is application/json.  (optional, default to application/json)
     * @param ifNoneMatch Validator for conditional requests; based on the ETag of the formerly retrieved variant of the resource (Will be supported in future).  (optional)
     * @param ifModifiedSince Validator for conditional requests; based on Last Modified header of the formerly retrieved variant of the resource (Will be supported in future).  (optional)
     * @return Tier
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Tier tiersTierLevelTierNameGet(String tierName, String tierLevel, String accept, String ifNoneMatch, String ifModifiedSince) throws ApiException {
        ApiResponse<Tier> resp = tiersTierLevelTierNameGetWithHttpInfo(tierName, tierLevel, accept, ifNoneMatch, ifModifiedSince);
        return resp.getData();
    }

    /**
     * Get details of a tier
     * This operation can be used to retrieve details of a single tier by specifying the tier level and tier name. Note that the scope of the API is mandatory while retreiving the access token with the following cURL command : &#x60;curl -k -d \\\&quot;grant_type&#x3D;password&amp;username&#x3D;username&amp;password&#x3D;password&amp;scope&#x3D;apim:tier_view\\\&quot; -H \\\&quot;Authorization: Basic &lt;token&gt;\\\&quot; https://127.0.0.1:8243/token&#x60;. You will receive the access token as the response, for example &#x60;\&quot;access_token\&quot;:\&quot;8644c013-7ff1-3217-b150-d7b92cae6be7\&quot;&#x60;. 
     * @param tierName Tier name  (required)
     * @param tierLevel List API or Application or Resource type tiers.  (required)
     * @param accept Media types acceptable for the response. Default is application/json.  (optional, default to application/json)
     * @param ifNoneMatch Validator for conditional requests; based on the ETag of the formerly retrieved variant of the resource (Will be supported in future).  (optional)
     * @param ifModifiedSince Validator for conditional requests; based on Last Modified header of the formerly retrieved variant of the resource (Will be supported in future).  (optional)
     * @return ApiResponse&lt;Tier&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Tier> tiersTierLevelTierNameGetWithHttpInfo(String tierName, String tierLevel, String accept, String ifNoneMatch, String ifModifiedSince) throws ApiException {
        com.squareup.okhttp.Call call = tiersTierLevelTierNameGetValidateBeforeCall(tierName, tierLevel, accept, ifNoneMatch, ifModifiedSince, null, null);
        Type localVarReturnType = new TypeToken<Tier>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get details of a tier (asynchronously)
     * This operation can be used to retrieve details of a single tier by specifying the tier level and tier name. Note that the scope of the API is mandatory while retreiving the access token with the following cURL command : &#x60;curl -k -d \\\&quot;grant_type&#x3D;password&amp;username&#x3D;username&amp;password&#x3D;password&amp;scope&#x3D;apim:tier_view\\\&quot; -H \\\&quot;Authorization: Basic &lt;token&gt;\\\&quot; https://127.0.0.1:8243/token&#x60;. You will receive the access token as the response, for example &#x60;\&quot;access_token\&quot;:\&quot;8644c013-7ff1-3217-b150-d7b92cae6be7\&quot;&#x60;. 
     * @param tierName Tier name  (required)
     * @param tierLevel List API or Application or Resource type tiers.  (required)
     * @param accept Media types acceptable for the response. Default is application/json.  (optional, default to application/json)
     * @param ifNoneMatch Validator for conditional requests; based on the ETag of the formerly retrieved variant of the resource (Will be supported in future).  (optional)
     * @param ifModifiedSince Validator for conditional requests; based on Last Modified header of the formerly retrieved variant of the resource (Will be supported in future).  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call tiersTierLevelTierNameGetAsync(String tierName, String tierLevel, String accept, String ifNoneMatch, String ifModifiedSince, final ApiCallback<Tier> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = tiersTierLevelTierNameGetValidateBeforeCall(tierName, tierLevel, accept, ifNoneMatch, ifModifiedSince, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Tier>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for tiersTierLevelTierNamePut */
    private com.squareup.okhttp.Call tiersTierLevelTierNamePutCall(String tierName, Tier body, String tierLevel, String contentType, String ifMatch, String ifUnmodifiedSince, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/tiers/{tierLevel}/{tierName}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "tierName" + "\\}", apiClient.escapeString(tierName.toString()))
        .replaceAll("\\{" + "tierLevel" + "\\}", apiClient.escapeString(tierLevel.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));
        if (ifMatch != null)
        localVarHeaderParams.put("If-Match", apiClient.parameterToString(ifMatch));
        if (ifUnmodifiedSince != null)
        localVarHeaderParams.put("If-Unmodified-Since", apiClient.parameterToString(ifUnmodifiedSince));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call tiersTierLevelTierNamePutValidateBeforeCall(String tierName, Tier body, String tierLevel, String contentType, String ifMatch, String ifUnmodifiedSince, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'tierName' is set
        if (tierName == null) {
            throw new ApiException("Missing the required parameter 'tierName' when calling tiersTierLevelTierNamePut(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling tiersTierLevelTierNamePut(Async)");
        }
        
        // verify the required parameter 'tierLevel' is set
        if (tierLevel == null) {
            throw new ApiException("Missing the required parameter 'tierLevel' when calling tiersTierLevelTierNamePut(Async)");
        }
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling tiersTierLevelTierNamePut(Async)");
        }
        
        
        com.squareup.okhttp.Call call = tiersTierLevelTierNamePutCall(tierName, body, tierLevel, contentType, ifMatch, ifUnmodifiedSince, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update a Tier
     * This operation can be used to update an existing tier. The only supported tier level is &#x60;api&#x60; tiers. &#x60;PUT https://127.0.0.1:9443/api/am/publisher/v0.14/tiers/api/Low&#x60;  **IMPORTANT:** * This is only effective when Advanced Throttling is disabled in the Server. If enabled, we need to use Admin REST API for throttling tiers modification related operations.
     * @param tierName Tier name  (required)
     * @param body Tier object that needs to be modified  (required)
     * @param tierLevel List API or Application or Resource type tiers.  (required)
     * @param contentType Media type of the entity in the body. Default is application/json.  (required)
     * @param ifMatch Validator for conditional requests; based on ETag (Will be supported in future).  (optional)
     * @param ifUnmodifiedSince Validator for conditional requests; based on Last Modified header (Will be supported in future).  (optional)
     * @return Tier
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Tier tiersTierLevelTierNamePut(String tierName, Tier body, String tierLevel, String contentType, String ifMatch, String ifUnmodifiedSince) throws ApiException {
        ApiResponse<Tier> resp = tiersTierLevelTierNamePutWithHttpInfo(tierName, body, tierLevel, contentType, ifMatch, ifUnmodifiedSince);
        return resp.getData();
    }

    /**
     * Update a Tier
     * This operation can be used to update an existing tier. The only supported tier level is &#x60;api&#x60; tiers. &#x60;PUT https://127.0.0.1:9443/api/am/publisher/v0.14/tiers/api/Low&#x60;  **IMPORTANT:** * This is only effective when Advanced Throttling is disabled in the Server. If enabled, we need to use Admin REST API for throttling tiers modification related operations.
     * @param tierName Tier name  (required)
     * @param body Tier object that needs to be modified  (required)
     * @param tierLevel List API or Application or Resource type tiers.  (required)
     * @param contentType Media type of the entity in the body. Default is application/json.  (required)
     * @param ifMatch Validator for conditional requests; based on ETag (Will be supported in future).  (optional)
     * @param ifUnmodifiedSince Validator for conditional requests; based on Last Modified header (Will be supported in future).  (optional)
     * @return ApiResponse&lt;Tier&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Tier> tiersTierLevelTierNamePutWithHttpInfo(String tierName, Tier body, String tierLevel, String contentType, String ifMatch, String ifUnmodifiedSince) throws ApiException {
        com.squareup.okhttp.Call call = tiersTierLevelTierNamePutValidateBeforeCall(tierName, body, tierLevel, contentType, ifMatch, ifUnmodifiedSince, null, null);
        Type localVarReturnType = new TypeToken<Tier>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update a Tier (asynchronously)
     * This operation can be used to update an existing tier. The only supported tier level is &#x60;api&#x60; tiers. &#x60;PUT https://127.0.0.1:9443/api/am/publisher/v0.14/tiers/api/Low&#x60;  **IMPORTANT:** * This is only effective when Advanced Throttling is disabled in the Server. If enabled, we need to use Admin REST API for throttling tiers modification related operations.
     * @param tierName Tier name  (required)
     * @param body Tier object that needs to be modified  (required)
     * @param tierLevel List API or Application or Resource type tiers.  (required)
     * @param contentType Media type of the entity in the body. Default is application/json.  (required)
     * @param ifMatch Validator for conditional requests; based on ETag (Will be supported in future).  (optional)
     * @param ifUnmodifiedSince Validator for conditional requests; based on Last Modified header (Will be supported in future).  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call tiersTierLevelTierNamePutAsync(String tierName, Tier body, String tierLevel, String contentType, String ifMatch, String ifUnmodifiedSince, final ApiCallback<Tier> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = tiersTierLevelTierNamePutValidateBeforeCall(tierName, body, tierLevel, contentType, ifMatch, ifUnmodifiedSince, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Tier>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for tiersUpdatePermissionPost */
    private com.squareup.okhttp.Call tiersUpdatePermissionPostCall(String tierName, String tierLevel, String ifMatch, String ifUnmodifiedSince, TierPermission permissions, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = permissions;
        
        // create path and map variables
        String localVarPath = "/tiers/update-permission".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (tierName != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "tierName", tierName));
        if (tierLevel != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "tierLevel", tierLevel));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (ifMatch != null)
        localVarHeaderParams.put("If-Match", apiClient.parameterToString(ifMatch));
        if (ifUnmodifiedSince != null)
        localVarHeaderParams.put("If-Unmodified-Since", apiClient.parameterToString(ifUnmodifiedSince));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call tiersUpdatePermissionPostValidateBeforeCall(String tierName, String tierLevel, String ifMatch, String ifUnmodifiedSince, TierPermission permissions, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'tierName' is set
        if (tierName == null) {
            throw new ApiException("Missing the required parameter 'tierName' when calling tiersUpdatePermissionPost(Async)");
        }
        
        // verify the required parameter 'tierLevel' is set
        if (tierLevel == null) {
            throw new ApiException("Missing the required parameter 'tierLevel' when calling tiersUpdatePermissionPost(Async)");
        }
        
        
        com.squareup.okhttp.Call call = tiersUpdatePermissionPostCall(tierName, tierLevel, ifMatch, ifUnmodifiedSince, permissions, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update tier permission
     * This operation can be used to update tier permissions which controls access for the particular tier based on the subscribers&#39; roles. 
     * @param tierName Name of the tier  (required)
     * @param tierLevel List API or Application or Resource type tiers.  (required)
     * @param ifMatch Validator for conditional requests; based on ETag (Will be supported in future).  (optional)
     * @param ifUnmodifiedSince Validator for conditional requests; based on Last Modified header (Will be supported in future).  (optional)
     * @param permissions  (optional)
     * @return List&lt;Tier&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Tier> tiersUpdatePermissionPost(String tierName, String tierLevel, String ifMatch, String ifUnmodifiedSince, TierPermission permissions) throws ApiException {
        ApiResponse<List<Tier>> resp = tiersUpdatePermissionPostWithHttpInfo(tierName, tierLevel, ifMatch, ifUnmodifiedSince, permissions);
        return resp.getData();
    }

    /**
     * Update tier permission
     * This operation can be used to update tier permissions which controls access for the particular tier based on the subscribers&#39; roles. 
     * @param tierName Name of the tier  (required)
     * @param tierLevel List API or Application or Resource type tiers.  (required)
     * @param ifMatch Validator for conditional requests; based on ETag (Will be supported in future).  (optional)
     * @param ifUnmodifiedSince Validator for conditional requests; based on Last Modified header (Will be supported in future).  (optional)
     * @param permissions  (optional)
     * @return ApiResponse&lt;List&lt;Tier&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Tier>> tiersUpdatePermissionPostWithHttpInfo(String tierName, String tierLevel, String ifMatch, String ifUnmodifiedSince, TierPermission permissions) throws ApiException {
        com.squareup.okhttp.Call call = tiersUpdatePermissionPostValidateBeforeCall(tierName, tierLevel, ifMatch, ifUnmodifiedSince, permissions, null, null);
        Type localVarReturnType = new TypeToken<List<Tier>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update tier permission (asynchronously)
     * This operation can be used to update tier permissions which controls access for the particular tier based on the subscribers&#39; roles. 
     * @param tierName Name of the tier  (required)
     * @param tierLevel List API or Application or Resource type tiers.  (required)
     * @param ifMatch Validator for conditional requests; based on ETag (Will be supported in future).  (optional)
     * @param ifUnmodifiedSince Validator for conditional requests; based on Last Modified header (Will be supported in future).  (optional)
     * @param permissions  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call tiersUpdatePermissionPostAsync(String tierName, String tierLevel, String ifMatch, String ifUnmodifiedSince, TierPermission permissions, final ApiCallback<List<Tier>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = tiersUpdatePermissionPostValidateBeforeCall(tierName, tierLevel, ifMatch, ifUnmodifiedSince, permissions, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Tier>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}