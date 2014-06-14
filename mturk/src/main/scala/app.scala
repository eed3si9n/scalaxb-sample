package mturk

object Main extends App {

  val test = <SearchHITsResponse
    xmlns="http://requester.mturk.amazonaws.com/doc/2012-03-25" 
    xmlns:soap11="http://schemas.xmlsoap.org/soap/envelope/">
      <OperationRequest>
        <RequestId>5a6d3168-9a3f-4047-8692-a6aa2f232015</RequestId>
      </OperationRequest>
      <SearchHITsResult>
        <Request>
          <IsValid>True</IsValid>
        </Request>
        <NumResults>52</NumResults>
        <TotalNumResults>52</TotalNumResults>
        <PageNumber>1</PageNumber>
        <HIT>
          <HITId>301KG0KX9CLLL69232QM007JAAR2HH</HITId>
          <HITTypeId>3XYCBL6ZTCVU16V08P82OU7EXNR2SC</HITTypeId>
          <HITGroupId>32SOQFN7RN5IE8J3TOUT6829GS9PIE</HITGroupId>
          <CreationTime>2014-04-25T13:20:15Z</CreationTime>
          <Title>Test HIT1398432014899</Title>
          <Description>This is a test HIT description.</Description>
          <HITStatus>Reviewable</HITStatus>
          <MaxAssignments>1</MaxAssignments>
          <Reward>
            <Amount>0.01</Amount>
            <CurrencyCode>USD</CurrencyCode>
            <FormattedPrice>$0.01</FormattedPrice>
          </Reward>
          <AutoApprovalDelayInSeconds>30</AutoApprovalDelayInSeconds>
          <Expiration>2014-04-25T13:20:45Z</Expiration>
          <AssignmentDurationInSeconds>30</AssignmentDurationInSeconds>
          <HITReviewStatus>NotReviewed</HITReviewStatus>
          <NumberOfAssignmentsPending>0</NumberOfAssignmentsPending>
          <NumberOfAssignmentsAvailable>1</NumberOfAssignmentsAvailable>
          <NumberOfAssignmentsCompleted>0</NumberOfAssignmentsCompleted>
        </HIT>
      </SearchHITsResult>
    </SearchHITsResponse>

  val obj = scalaxb.fromXML[SearchHITsResponse](test)
  println(obj)
}
